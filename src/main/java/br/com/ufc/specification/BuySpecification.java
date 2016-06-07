package br.com.ufc.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.ufc.model.Buy;

public class BuySpecification {

	public static Specification<Buy> buyQuantityGreaterThan(final int quantity) { 
		return new Specification<Buy>() {

			@Override
			public Predicate toPredicate(Root<Buy> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.greaterThanOrEqualTo(root.<Integer>get("quantity"), quantity);
			}
			
		};
	}
	
	public static Specification<Buy> allBuyBetween(final Date fromDate, final Date toDate, final boolean active) { 
		return new Specification<Buy>() {

			@Override
			public Predicate toPredicate(Root<Buy> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.and(cb.between(root.<Date>get("date"), fromDate, toDate), cb.equal(root.<Boolean>get("active"), active));
//				return cb.between(root.<Date>get("date"), fromDate, toDate);
			}
			
		};
	}
}