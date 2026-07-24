/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.giaolang.mathutil.core;

/**
 *
 * @author Hii
 */
public class MathUtil {
    
    //trong class này cung cấp ai đó nhiều hàm xử lí 
    //clone class Math của JDK
    //hàm thư viện xài chung cho ai đó, ko cần lưu lại trạng  thái / giá trị
    //hàm tính giai thừa 
    //n! = 1.2.3.4....n
    //ko có giai thừa cho số âm
    //giai thừa hàmđồ thị dốc đứng, tăng nhanh về giá trị
    //20 giai thừa thừa 18 con số 0, vừa kịp đủ cho kiểu int 
    //21 giai thừa tràn kiểu long
    //bài này quy ước tính n! trong khoảng từ 0.200
    public static long getFactorial(int n){
        if(n < 0 || n > 20)
            throw new IllegalArgumentException
            ("Invalid argument. N must be between 0..20");
        
        if(n == 0 || n == 1)
            return 1; //kết thúc cuộc chơi sớm nếu nhận những đầu vào đặc biệt
        
        long product = 1; //tích nhân dồn, thuật toán con heo đất, ốc bu dồn thịt
        
        for (int i = 2; i <= n; i++) 
            product *= i;
        return product;
    }
    
}
