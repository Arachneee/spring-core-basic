package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService {


//    private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();
//    private final DisCountPolicy disCountPolicy = new RateDiscountPolicy(); // DIP/OCP 위반
    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy;


    // lombok으로 만들어줌
//    @Autowired  //생략 가능 생성자 1개만 있을 때.
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
