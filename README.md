#TF-IDF Algorithm

The TF-IDF is an information retrieval technique to weigh a keyword and assign the importance of it based on the number of times that the keyword appears in documents. 

##How it works?
The first thing that we have to look at is how many times each words (in each documents) appears, then we added to an matrix, where we have the words (as lines) and the document reference (as columns), for each document some word appears x times, doing this we have the term's frequency (TF) matrix. Now we have to calculate the inverse document frequency (IDF), in this part we have two steps, for each word we have to calculate \[\log \left ( \frac{N}{df_i} \right )\].
