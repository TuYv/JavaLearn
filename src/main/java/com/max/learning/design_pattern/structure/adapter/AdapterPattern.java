package com.max.learning.design_pattern.structure.adapter;

/**
 * @author max
 * @description: 适配器模式
 * @date 2021/8/13 17:26
 */
public class AdapterPattern {

    //目标：发动机
    interface Motor
    {
        public void drive();
    }
    //适配者1：电能发动机
    class ElectricMotor
    {
        public void electricDrive()
        {
            System.out.println("电能发动机驱动汽车！");
        }
    }
    //适配者2：光能发动机
    class OpticalMotor
    {
        public void opticalDrive()
        {
            System.out.println("光能发动机驱动汽车！");
        }
    }
    //电能适配器
    class ElectricAdapter implements Motor
    {
        private ElectricMotor emotor;
        public ElectricAdapter()
        {
            emotor=new ElectricMotor();
        }
        public void drive()
        {
            emotor.electricDrive();
        }
    }
    //光能适配器
    class OpticalAdapter implements Motor
    {
        private OpticalMotor omotor;
        public OpticalAdapter()
        {
            omotor=new OpticalMotor();
        }
        public void drive()
        {
            omotor.opticalDrive();
        }
    }
}
