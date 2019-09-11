package com.company.AnnaNicholsU1M5Summative.dao;

import com.company.AnnaNicholsU1M5Summative.dto.Publisher;

import java.util.List;

public interface PublisherDao {
    Publisher addPublisher(Publisher publisher);

    Publisher getPublisher(int id);

    List<Publisher> getAllPublishers();

    void updatePublisher(Publisher publisher);

    void deletePublisher(int id);
}
