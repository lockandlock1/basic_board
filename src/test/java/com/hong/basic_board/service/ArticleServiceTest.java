package com.hong.basic_board.service;

import com.hong.basic_board.domain.Article;
import com.hong.basic_board.domain.type.SearchType;
import com.hong.basic_board.dto.ArticleDto;
import com.hong.basic_board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@DisplayName("비지니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        // Given
//        SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        // Given
//        SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // When
        ArticleDto article = sut.searchArticle(1L); // 제목, 본문, ID, 닉네임, 해시태그

        // Then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정볼르 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // Given
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "Uno", "title", "content", "#java");
        given(articleRepository.save(any(Article.class))).willReturn(null);


        // When
        sut.saveArticle(dto);

        // Then
        then(articleRepository).should().save(any(Article.class));
    }
}