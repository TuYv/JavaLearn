package com.max.design.structure.adapter;

/**
 * @author max
 * @description: 适配器模式
 * 适配器模式分为类适配器和对象适配器, 类是直接继承使用, 对象是持有一个目标类的对象
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
