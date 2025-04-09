package org.digitalcity.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/4/7
 */

@Data
@TableName("circle_inf")
public class CircleInf {
    private int id;
    private String name;
    // 学校数量
    private int school;
    // 便利店数量
    @TableField("convenience_store")
    private int convenienceStore;
    // 超市数量
    private int supermarket;
    // 菜场数量
    @TableField("vegetable_market")
    private int vegetableMarket;
    // 医院数量
    private int hospital;
    // 药店数量
    private int drugstore;
    // 银行数量
    private int bank;
    // 小区数目
    private int community;
    // 景点数量
    @TableField("scenic_plot")
    private int scenicPlot;
    // 停车场数量
    @TableField("parking_lot")
    private int parkingLot;
    // 公共厕所数量
    private int wc;
    // 警局数量
    private int police;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
