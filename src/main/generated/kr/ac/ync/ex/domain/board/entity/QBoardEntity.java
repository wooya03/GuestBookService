package kr.ac.ync.ex.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = 376606458L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final kr.ac.ync.ex.global.common.entity.QBaseEntity _super = new kr.ac.ync.ex.global.common.entity.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kr.ac.ync.ex.domain.member.entity.QMemberEntity member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath title = createString("title");

    public QBoardEntity(String variable) {
        this(BoardEntity.class, forVariable(variable), INITS);
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardEntity(PathMetadata metadata, PathInits inits) {
        this(BoardEntity.class, metadata, inits);
    }

    public QBoardEntity(Class<? extends BoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new kr.ac.ync.ex.domain.member.entity.QMemberEntity(forProperty("member")) : null;
    }

}

