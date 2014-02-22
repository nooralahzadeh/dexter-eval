Dexter Eval
===========

Dexter Eval is an entity linking evaluation framework, inspired by the **bat-framework** [1].
 
The entity linking task aims at identifying 
all the small text fragments in a document 
referring to an entity contained in a given 
knowledge base. In our setting the KB is Wikipedia.

Given a text T,  an entity linker usually annotates
it producing a list of **spots** (aka mentions, or annotations), 
i.e., substrings of text that refer to an entity. The linker
associates to each spot a Wikipedia/Dbpedia entity 
(represented by the Wikipedia `pageid` [details](http://www.mediawiki.org/wiki/API:Query)).

Each annotation returned by a linker then can be represented
as a tuple `<start, end, wiki-id, score>` where:

 * `start` represents the starting position of the spot in the annotated text;
 * `end` represents the ending position;
 * `wiki-id` the id of the entity associated by the linker;
 * `score` the confidence of the linker on the entity. associated. 
 
 Researchers produced several datasets[2] for evaluating
 entity linking methods, but **the main problem is how to evaluate?** Depending on your needs, you could only consider the annotated wiki-ids (with no interest for the positions), or you would like to ignore the entities and check if your entity linker is good in detecting the correct positions
 of the spots and so on. **Dexter-eval** allows you to 
 evaluate your method with the //metrics// you prefer. 
 
 ## How to evaluate
 
 
 
 
 
 
 [1] [bat-framework github](https://github.com/marcocor/bat-framework), [bat-framework website](http://acube.di.unipi.it/bat-framework/)
 
 [2] A Framework for Benchmarking Entity-Annotation Systems, Marco Cornolti and Paolo Ferragina and Massimiliano Ciaramita, Proceedings of the International World Wide Web Conference (WWW 2013) [pdf](http://static.googleusercontent.com/media/research.google.com/en//pubs/archive/40749.pdf). The paper describes several available datasets. 
 
 
 



 

 

