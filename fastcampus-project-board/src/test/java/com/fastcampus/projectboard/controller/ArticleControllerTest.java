package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.config.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 - 게시글")
@Import(SecurityConfig.class)
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[View][GET] 게시글 리스트 페이지 정상호출")
    @Test
    void givenNothing_whenRequestArticlesView_thenReturnArticlesView() throws Exception {
        //Given

        //When

        //Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[View][GET] 게시글 상세 페이지 정상호출")
    @Test
    void givenNothing_whenRequestArticleView_thenReturnArticleView() throws Exception {
        //Given

        //When

        //Then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComment"));
    }

    @Disabled("구현중")
    @DisplayName("[View][GET] 게시글 검색 페이지 정상호출")
    @Test
    void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchView() throws Exception {
        //Given

        //When

        //Then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/search"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Disabled("구현중")
    @DisplayName("[View][GET] 게시글 해시태그 검색 페이지 정상호출")
    @Test
    void givenNothing_whenRequestArticleHashtagSearchView_thenReturnArticleHashtagSearchView() throws Exception {
        //Given

        //When

        //Then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/search-hashtag"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}