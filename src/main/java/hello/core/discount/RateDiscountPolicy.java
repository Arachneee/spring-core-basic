package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")    //이름으로 선택
//@Primary // bean 중복 일때 우선 선택
@MainDiscountPolicy
public class RateDiscountPolicy implements DisCountPolicy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price / 100 * discountPercent;
        }
        return 0;
    }
}
