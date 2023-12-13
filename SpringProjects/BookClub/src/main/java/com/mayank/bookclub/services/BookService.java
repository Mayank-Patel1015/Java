package com.mayank.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mayank.bookclub.models.Book;
import com.mayank.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
//	@Autowired
//	private DonationRepository donationRepo;
	
	private final BookRepository donationRepo;

	public BookService(BookRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public Book getOne(Long id) {
		Optional<Book> donation = donationRepo.findById(id);
		return donation.isPresent() ? donation.get() : null;
	}

	public List<Book> getAll() {
		return (List<Book>) donationRepo.findAll();
	}

	public Book create(Book donation) {
		return donationRepo.save(donation);
	}

	public Book update(Book donation) {
		return donationRepo.save(donation);
	}

	public void delete(Long id) {
		donationRepo.deleteById(id);
	}

}
