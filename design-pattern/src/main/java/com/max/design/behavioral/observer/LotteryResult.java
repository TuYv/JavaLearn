package com.max.design.behavioral.observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Rick
 * @date 2021-12-06 21:51
 */
@Data
@AllArgsConstructor
public class LotteryResult {

    private String uId;

    private String message;

    private Date dateTime;

}
