package br.com.ufc.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Buy;
import br.com.ufc.repository.BuyRepository;
import br.com.ufc.specification.BuySpecification;

@Service
@Transactional
public class BuyService implements IBuyService {

	@Autowired
	private BuyRepository repository;

	@Override
	public List<Buy> findAll() {
		return repository.findAll();
	}

	@Override
	public Buy findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Buy save(Buy buy) {
		return repository.save(buy);
	}

	@Override
	public Buy update(Buy buy) {

		if (!(repository.exists(buy.getId()))) {
			throw new EmptyResultDataAccessException(1);
		}

		return repository.save(buy);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

	@Override
	public List<Buy> buyQuantityGreaterThan(int quantity) {
		return repository.findAll(Specifications.where(BuySpecification.buyQuantityGreaterThan(quantity)));
	}

	@Override
	public List<Buy> allBuyBetween(Date fromDate, Date toDate, boolean active) {
		List<Buy> buyList = null;

		if (fromDate != null && toDate != null) {
			buyList = repository.findAll(Specifications
					.where(BuySpecification.allBuyBetween(fromDate, toDate))
					.and(BuySpecification.findByActive(active)));
		}

		return buyList;
	}

}
