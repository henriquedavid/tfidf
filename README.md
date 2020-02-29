# TF-IDF Algorithm

## Henrique David de Medeiros

The TF-IDF is an information retrieval technique to weigh a keyword and assign the importance of it based on the number of times that the keyword appears in documents. 

## Prerequisite

- Java
- JDK 11

_This project was loaded on Eclipse using above configurations_

## How it works?

The first thing that we have to look at it's how many times each words (in each documents) appears, then we added to an matrix, where we have the words (as rows) and the document reference (as columns), for each document some word appears x times, doing this we have the term's frequency (TF) matrix. Now we have to calculate the Inverse Document Frequency (IDF), in this part we have two steps, for each word, we have to calculate log (number of all documents/number of documents where the word it's showed); then, the last step it's to multiply the log with each value on the TF Matrix, taking a new matrix with the result of weight in each word in each document.

## Why?

The TF-IDF is an algorithm that can make magic if you have some business, you can take a look more deeply from what your clients are saying about your store, or what your clients are searching more in your app, in your store, you can truly change your life studying which words are more being used in your life.

## Author

Henrique David de Medeiros\\
IT and Computer Science Student. IT Technician (since 2016)\\
Email: _henriquemed101@gmail.com_
