package user;

import com.x7.sdk.client.X7Client;
import com.x7.sdk.model.request.GetUserRealNameInfoRequest;
import com.x7.sdk.model.request.LoginCheckRequest;
import com.x7.sdk.model.response.GetUserRealNameInfoResponse;
import com.x7.sdk.model.response.LoginCheckResponse;
import com.x7.sdk.service.UserService;
import org.junit.Test;

public class UserServiceTest {
    private final static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDDxRpuKIdYQ3lRHlIHJLbwJUKJVSVORZEISw/flJmz1rXATtuiKuPSGmDvDK7qF7J0imX3gF7DPAzckd7jlL9Ri95hCj/Ovclvjq+mgkxA+KQ3JlI5HGaM+WjMi4CVhbnpfcB6t75iQfW4IV556pbQFxPg2+WOfe/IkZiXM7eRYK6KdkfTCGvFK2LJvlImmOWDHP4xVS4EAkINgBGjpYK4IBNO537/3vCykEJ5yz+W29RA9oal6EKFsLbhTdUGYuxIKbGMA8tAki6QfqzLq1WgrmOaM2cWwKtZuR3rwfq2yb10Y9xQyA1bF5qFT/y1I61f3gBpN9Thynzjpift0fglAgMBAAECggEAIVoJ96xl6m6MU3qD5P2nQOBIJpdf5KbLX4tSJ/fr+4xfqGSG3GjMKTYfP3p8rhrdZydQ2cp/2mj3k/gx7bmgombeus+BMVp538yCNi7KiOMTLuYTafFhszCmXvqBLHf8xT+MNBvrjlfIYdclfkWt7cOQumUcBZuE5zmOsmu4IUb4ArjKsEmGDqdsp3fCESzbMWqBinvOmdUy+3VbBTpSjU/PDWCd/OgnTHpwPY7O9T7zSo8grkkWyq79W5kz7PLXdtqt1DNChUjHHv+ANM3T5L127BlHDskyG24AGrDzLmCmNQab4qFtOjPtHdsXsQm8cllgzD4lvP6ThuAG8DK4IQKBgQDnoCY8CLc2kUNyibdaA5N7y4xaY9vm1t6jKf37fOS069GkUNfOb8r+Pxp70UAKzMBWZ4iVlDbEh3FU0jveYutsUUbjEB4qI19/jvUHahKzaE9DCK3HkGvjT3NkQmZ+LslS/CxJtyZl+mN8/Ur6OA7p/l8BuJMVMXY+G7mQRZVtzQKBgQDYXwZX712DP5DTLcoUwOM9mIa8UFIFoZN+lwKLq8c0wbpZ3uicU90YwCPVvuATp/fwjOgOEId8HkLeBXkbqkJRimI0y4bTPzHNk0JDlTso79ERcglA9wU4j3C6OArB0Id/u2cVSex/JW3arQt2jRk5JCSDtWn7k1cB9qPvckUbuQKBgA3nYSQtacIOyjuv5J+0oz/FIjGy2Npsf4TP2n0kLB5oIXd5mtq7fzXv18ki8HM1gz4sjNhdw0Pc1YK/8/QPgA5KerTanNTutqbTkAXX6jN2yXs+pB/cnX1RoZ2dFsXwTQl8NbRfGCD6/Mnd8og+oTaOnGlgCQQ2qeBkjakJZETpAoGBAIu/FAHHf8Y9T/SVJmexDRPDZ4JI/jDU4sZoEiTTlZ3lYc6ZwfL1118c+ggbd+46FlEvMNGkq1zmzplHP6k2lg7EKhmfOj1GG4yDB9FOmR8fhRCXbpKe+KhHPK+JcqkrXdiJ2VJOpIiaTBFoona3OwtE5LCMgx8RUqjZ+5ezXh9BAoGBAIz5//GXs1kJoGQatr0rvE4CvVLVbKHaVaXy7MAcp4uya3g1cZh3Swje8e4RD6UfiKmx+aPETfw9IkXbrPTYmXCNDx5bSbbPL+WMY8c7F7K0krOfl8Vtzg5cCfo45+IsLCM16sDT0MhLCPUMWj0kcd4bKcAc3CENaL3U03oLE58r";
    private final static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw8UabiiHWEN5UR5SByS28CVCiVUlTkWRCEsP35SZs9a1wE7boirj0hpg7wyu6heydIpl94BewzwM3JHe45S/UYveYQo/zr3Jb46vpoJMQPikNyZSORxmjPlozIuAlYW56X3Aere+YkH1uCFeeeqW0BcT4Nvljn3vyJGYlzO3kWCuinZH0whrxStiyb5SJpjlgxz+MVUuBAJCDYARo6WCuCATTud+/97wspBCecs/ltvUQPaGpehChbC24U3VBmLsSCmxjAPLQJIukH6sy6tVoK5jmjNnFsCrWbkd68H6tsm9dGPcUMgNWxeahU/8tSOtX94AaTfU4cp846Yn7dH4JQIDAQAB";



    @Test
    public void testLoginCheck() {
        try {
            X7Client client = new X7Client(publicKey, privateKey);
            UserService userService = client.getUserService();

            LoginCheckRequest request = new LoginCheckRequest();
            request.setAppKey("0b9ce7b64b02fb17cc948c0b9a6eb462");
            request.setTokenKey("e7854780ec04372d64025c1bb29a5560");

            LoginCheckResponse response = userService.loginCheck(request);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetUserRealNameInfo() {
        try {
            X7Client client = new X7Client(publicKey, privateKey);
            UserService userService = client.getUserService();

            GetUserRealNameInfoRequest request = new GetUserRealNameInfoRequest();
            request.setData("BBi8tEkGG6fd1e805VEFx/OBA4U2VK/hJH+6rDs5qD07xdjl3Uapif1YRVQsXCKPNWJLzDI9S5CEPv5rKCpuKKi8Eh4lX1/7oCJDes99f+/qhVZhupPqU9RjIjTcfrBdcdx3uD4xVuYtURTbWCzxsD24GF7kc9eX87hnLUd1CzRHTDA3093KyA6ep3JAX/BGVjhkoJITkGmCpFszvh2VJxe5R0ZroDXwuAOKd3f4i3XEWnjmH8BphlX4xqMlBw5s0pE+Uhm5l1IBY8CLMG6tln89IqGg9nwmWNJqXRvX0bfiqEr8GTusOjTy5aLItmW4w4BhHZoyTn6/xBvs7drrv5oCMV65n9ut1tRVDkraDKqFQhCJjRe06v/I0mJgrrgaBUlIaaUPT9CCGqyfxWLATGe4/OrDgmgVee7C6szBdAyG+LEMtB/q/KO1anaBrazJ7fxHoqb2nb6b6k9XWH7dwZFKnFU3RyhyEzuujjK4C9ramjios/X2qocAap5P6yoJQD9O/FRuei6K72SbL1nhruXpdKLhiC+pidTe64K6RREZ028yLjn6h6TCI1/eomkhxKl6pJy86igylC5yoGzgnQMk+2U2Sx6bX5O+TdR32Rs53y+DxMb81oq8uXcV/lukq1X5MybjFKGnPNER66Wje31ezgwbh8EUpdaGTP01rQ8=");

            GetUserRealNameInfoResponse userRealNameInfo = userService.getUserRealNameInfo(request);
            System.out.println(userRealNameInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
