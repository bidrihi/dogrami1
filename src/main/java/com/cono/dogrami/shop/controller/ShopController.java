package com.cono.dogrami.shop.controller;

import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.notice.model.vo.Notice;
import com.cono.dogrami.shop.model.service.ShopService;
import com.cono.dogrami.shop.model.vo.Shop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    //샵 리스트
    @RequestMapping("shop.do")
    public ModelAndView shopListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        // 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
        // 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
        int limit = 9; // 한 페이지에 출력할 목록 갯수
        // 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
        int listCount = shopService.selectListCount();
        String url = "shop.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);
        paging.calculator();
        logger.info("page : " + page);

        ArrayList<Shop> list = shopService.selectList(paging);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("paging", paging);
            mv.setViewName("shop/shopList");
        } else {
            mv.setViewName("shop/shopList");
        }
        return mv;
    }

    //사이트 작성으로 이동
    @RequestMapping("shopwrite.do")
    public String moveShopWriteForm() {
        return "shop/shopWriteForm";
    }

    //사이트 추가하기
    @RequestMapping(value = "shopinsert.do", method = RequestMethod.POST)
    public String shopInsertMethod(Shop shop, Model model, HttpServletRequest request, @RequestParam("upfile") MultipartFile mfile) {

        //게시글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/shop_upfiles");

        //첨부파일이 있을때
        if (!mfile.isEmpty()) {

            //전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 공지글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서  폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                //바꿀 파일명에 대한 문자열 만들기

                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
                logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);

                //파일 객체 만들기
                File renameFile = new File(savePath + "\\" + renameFileName);

                //폴더에 저장 처리
                try {
                    mfile.transferTo(renameFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }

                //객체에 첨부파일 정보 기록 저장
                shop.setSite_image(fileName);
                shop.setSite_image_rename(renameFileName);
            }
        }

        if (shopService.insertShop(shop) > 0) {
            return "redirect:shop.do";
        } else {
            model.addAttribute("message", "등록 실패");
            return "common/error";
        }
    }

    //사이트 수정으로 이동
    @RequestMapping("shopupview.do")
    public String moveShopUpdateView(@RequestParam("shop_no") int shop_no, Model model) {

        Shop shop = shopService.selectShop(shop_no);

        if (shop != null) {
            model.addAttribute("shop", shop);
            return "shop/shopUpdateForm";
        } else {
            model.addAttribute("message", shop_no + "에 대한 정보가 없습니다");
            return "common/error";
        }
    }

    //사이트 수정하기
    @RequestMapping(value = "shopupdate.do", method = RequestMethod.POST)
    public String shopUpdateMethod(Shop shop, Model model, HttpServletRequest request, @RequestParam(name = "delfile", required = false) String delFlag, @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시원글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/shop_upfiles");

        //2. 게시글 첨부파일은 1개만 가능한 경우
        //새로운 첨부파일이 있을때
        if (!mfile.isEmpty()) {
            //2-1. 이전 첨부파일이 있을 때
            if (shop.getSite_image() != null) {
                //저장 폴더에 있는 이전 파일을 삭제함
                new File(savePath + "\\" + shop.getSite_image_rename()).delete();
                //이전 파일 정보도 제거함
                shop.setSite_image(null);
                shop.setSite_image_rename(null);
            }

            //2-2. 이전 첨부파일이 없을 때 전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 게시글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서 폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
                logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);
                //폴더에 저장 처리
                try {
                    mfile.transferTo(new File(savePath + "\\" + renameFileName));
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }

                //객체에 첨부파일 정보 기록 저장
                shop.setSite_image(fileName);
                shop.setSite_image_rename(renameFileName);
            }
        }

        if (shopService.updateShop(shop) > 0) {
            //수정 성공시 샵 페이지로 이동
            return "redirect:shop.do";
        } else {
            model.addAttribute("message", shop.getShop_no() + "번 사이트 수정 실패!");
            return "common/error";
        }
    }

    //사이트 검색하기
    @RequestMapping(value = "shopsearch.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView shopSearchMethod(@RequestParam("action") String action, @RequestParam(name = "page", required = false) String page, @RequestParam("keyword") String keyword, ModelAndView mv) {

        ArrayList<Shop> list = null;
        int currentPage = 1;

        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        int limit = 10;
        int listCount = 0;

        String url = "shopsearch.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);
        listCount = shopService.selectListCountSearch(params);

        paging.setListCount(listCount);
        paging.calculator();
        params.put("paging", paging);
        list = shopService.selectSearch(params);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);
            mv.setViewName("shop/shopList");
        } else {
            mv.setViewName("redirect:shopList.do");
        }

        return mv;
    }

    //사이트 삭제
    @RequestMapping("shopdelete.do")
    public String noticeDeleteMethod(@RequestParam("shop_no") int shop_no, @RequestParam("site_image_rename") String renameFileName, HttpServletRequest request, Model model) {

        if (shopService.deleteShop(shop_no) > 0) {
            if (renameFileName != null) {
                String savePath = request.getSession().getServletContext().getRealPath("resources/shop_upfiles");

                new File(savePath + "\\" + renameFileName).delete();
            }
            return "redirect:shop.do";
        } else {
            model.addAttribute("message", shop_no + "번 글삭제 실패");
            return "common/error";
        }
    }
}
