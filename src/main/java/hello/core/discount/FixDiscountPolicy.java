package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

	private final int discountFixeAmount = 1000;

	@Override
	public int discount(Member member, int price) {
		if (member.getGrade() == Grade.VIP){
			return discountFixeAmount;
		} else {
			return 0;
		}
	}
}
