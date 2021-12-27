package com.ark.valguero.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO
 *
 * @author 巴黎欧莱雅
 * @version 1.0
 * @date 2021/12/27 17:51
 * @e-mail SpringCloud2.0@outlook.com
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private String name;
    private String owner;
    private Number value;
    private String makeModel;
}
