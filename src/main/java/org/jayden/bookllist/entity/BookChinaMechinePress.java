package org.jayden.bookllist.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangfeifan
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BookChinaMechinePress implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String author;

    private String summary;

    private String isbn;

    private LocalDate date;

    private String price;

    private String pics;


}
