package com.example.arom1.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eatery_id")
    private Eatery eatery;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE)
    private List<BoardReply> replies = new ArrayList<>();

    @Builder
    private Board(Long id, String title, String content) { //수정
        this.id = id;
        this.title = title;
        this.content = content;
    }



}