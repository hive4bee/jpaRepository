package com.hive4bee.ansj.persistence;

import com.hive4bee.ansj.domain.QWebBoard;
import com.hive4bee.ansj.domain.QWebReply;
import com.hive4bee.ansj.domain.WebBoard;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log
@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport {

    private final JPAQueryFactory query;

    public BoardRepositoryImpl(JPAQueryFactory query){
        super(WebBoard.class);
        this.query = query;
    }

    public List<Tuple> list(){
        QWebBoard qWebBoard = QWebBoard.webBoard;
        QWebReply qWebReply = QWebReply.webReply;
        QueryResults<Tuple> queryResult=query
                .select(qWebBoard, qWebReply)
                .from(qWebBoard)
                .join(qWebReply).on(qWebReply.board().bno.eq(qWebBoard.bno))
                .fetchResults();
        List<Tuple> content=queryResult.getResults();
        long totalCount=queryResult.getTotal();
        log.info("content:"+content+" / totalCount:"+totalCount);
        return content;
    }

}
