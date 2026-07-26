/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.giaolang.mathutil.test.core;

import com.giaolang.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Hii
 */
public class MathUtilityTest {

    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm thử / kiểm tra code chính - hàm tínhGiaiThừa() bên
    //class core.MathUtil
    //viết code để test code chính bên kia !!1
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, ko chơi đưa -5!, 30!
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long expected = 1; //hy vọng 0! = 1
//        long actual = ; ///gọi hàm cần test bên core / app chính / code chính
        long actual = MathUtil.getFactorial(n);

        //so sánh expected vs. actual dùng xanh xanh đỏ đỏ, framework
        Assert.assertEquals(expected, actual);

        //gộp thêm vài case thành công / đưa đầu vào ngon !!! hàm phải tính ngon
        Assert.assertEquals(1, MathUtil.getFactorial(1)); //tui muốn 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); //tui muốn 2! == 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); //tui muốn 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); //tui muốn 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); //tui muốn 5! == 120
        Assert.assertEquals(120, MathUtil.getFactorial(6)); //tui muốn 6! == 720

        //hàm giúp so sánh 2 giá trị nào đó có giống nhau hay không 
        //nếu giống nhau -> thảy màu xanh đèn đường - đường thông, code ngon
        //                  ít nhất cho case đang test
        //nếu KO GIỐNG NHAU -> thảy màu đỏ đèn đường
        //                  hàm ý expected và actual ko giống nhau
    }

    //hàm getF() ta thiết kế có tình huống xử lí
    //1. đưa data tử tế trong [0 ... 20] -> tính đúng được n! - done
    //2. đưa data vào cà chớn, âm, > 20;THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ 
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với n cà chớn này
    //nếu hàm chặn vào n < 0 hoặc n > 20 và hàm éo ném ra ngoại lệ 
    //sure, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐĐ
    //Test case:
    //input: -5
    //expected: IllegalArgmentException xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    //là những thứ ko thể đo lường so sánh theo kiểu value
    //mà chỉ có thể đo lường bằng cách chúng có xuất hiện hay ko
    //assertEquals() ko dùng để so sánh 2 ngoại lệ
    //      equals() là bằng nhau hay ko trên value!!!
    //MÀU ĐỎ ĐÓ EM, DO HÀM ĐÚNG LÀ CÓ NÉM NGOẠI LỆ THẬT SỰ
    //NHƯNG KO PHẢI LÀ NGOẠI LỆ NHƯ KÌ VỌNG - THỰC SỰ KÌ VỌNG SAI
    //KO PHẢI HÀM NÉM SAI
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenRightArgumentThrowsException(){
//        MathUtil.getFactorial(-5);
//    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenRightArgumentThrowsException() {
        MathUtil.getFactorial(-5);
    }
    
    //cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!
    //xài Lambda
    //Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    @Test
    public void testGetFactorialGivenRightArgumentThrowsException_LambdaVersion() {
        
//        Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh, 
//                            tham số 2: loại code chạy văng ra runnable);
        
        Assert.assertThrows(IllegalArgumentException.class, 
                            () -> MathUtil.getFactorial(-5));

//        MathUtil.getFactorial(-5);
    }
    
    
    //Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay ko khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh 
    @Test
    public void testGetFactorialGivenRightArgumentThrowsException_TryCatch() {
              
        //chủ động kiểm soát ngoại lệ !!!
        try {
            MathUtil.getFactorial(21);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát
            //ngoại lệ, nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko
            //có đoạn code kiểm soát đúngngoại lệ IllegalArgumentException
            
            Assert.assertEquals("Invalid argument. N must be between 0..20", 
                    e.getMessage());
        }
        
    }
}

/*

KĨ THUẬT DDT KHI CHƠI VỚI UNIT TEST 
DDT VIẾT TẮT CỦA DATA DRIVEN TESTING - kĩ thuật kiểm thử hướng theo tập data
chuẩn bị sẵn
là kĩ thuật tách lời gọi hàm cần tets ra 1 chỗ 
                            data đầu vào expected vào 1 chỗ khác
                            nhồi / nạp / feed đám data này vào lời gọi hàm
giúp:
                            nhìn code test dễ dàng trong sáng, 
                                tách biệt việc chuẩn bị data 
                            ra 1 chỗ -> ta dễ tập trung trong việc build
                                bộ data test 
                            ko bị trộn với code test đám data này 
                            vì việc kiểm thử đòi hỏi tính chặt chẽ cẩn 
                                thận
                            code để test code cũng cần phải đẹp, 
                                dễ bảo trì

Trong giới công nghiệp cá công ty phần mềm, tập data để ở
-trong file Excel theo hàng cột
-trong text file (dùng tab để phân cách giá trị) dạng CSV
-nhúng trực tiếp trong code, nhưng tách so với code JUnit Test 
-để trong table của database chứa toàn data để test, ko phải là 
database của app

Phân tích bài test hàm tính giai thừa
Input (n)           Expected (n!)
0                   1
1                   1
2                   2          
3                   6
4                   24
5                   120
6                   720

Assert.assertEquals(expected, getF(input))  //tập data cần verify đặt thành
                                            các biến, feed các biến vào 
                                            code JUnit / Unit Test

kĩ thuật DDT
trong sáng, dễ hiễu, dễ đánh giá được thiếu case hay ko, tình huống xài
hàm đã có đủ đại diện chưa !!!

CHỐT DEAL: DDT chẳng qua là tách tập data test ra 1 chỗ, đặt cho chúng 
thành các biến tương ứng, rồi đưa biến vào hàm test !!1
DDT còn đc gọi 1 tên mới: KIỂM THỬ UNIT TEST KIỂU THAM SỐ HÓA
                          PARAMETERIZED 
                          (Kỹ thuật tham số hóa tập data test)


Assert.assertEquals(1, getF(0))
Assert.assertEquals(1, getF(1))
Assert.assertEquals(720, getF(6))

*/
