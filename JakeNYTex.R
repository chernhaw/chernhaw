

theCall <- "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=taleban&api-key=tO2yo5wBn2nnojTIjbzxytCmyukYl4mH"


require(plyr)
require(rjson)
require(RTextTools)
# first look at the results
res1 <-fromJSON(file=theCall)
# how long is the result
res1

length(res1$response$docs[[1]]$abstract)
# look at first item
res1$results[[1]]
# first item's title

#the first item as data frame
as.data.frame(res1$response$docs[[1]]$abstract)
res1$response$docs
# convert the call result into a data.frame, should be 10 rows by 3 rows
res1$response$docs[[1]]$headline

resultsTaleban <- vector("list",3)



theCall <-"https://api.nytimes.com/svc/search/v2/articlesearch.json?q=%s&api-key=tO2yo5wBn2nnojTIjbzxytCmyukYl4mH"
#theCall <- "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=%s&api-key=tO2yo5wBn2nnojTIjbzxytCmyukYl4mH"
## now let's build this for multiple calls
# build a string where we will substitute the section for the first %s and offset for second %s
resultsTaleban <- vector("list",3)
i<-0

for (i in 0:2)
{
  
  resultsTaleban[[i+1]]<-ldply(res1$response$docs[[i+1]]$headlin, as.data.frame)
  
  
}
resultsTaleban
  
theCall <- "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=olympics&api-key=tO2yo5wBn2nnojTIjbzxytCmyukYl4mH"
 
  
  tempJson <- fromJSON(file=theCall)
  resultsOlymipcs <- vector("list",3)
  # convert the json into a 10x3 data frame and
  #save it to the list
  tempJson
  
  for (i in 0:2)
  {
    resultsOlymipcs[[i+1]]<-ldply(  tempJson$response$docs[[i+1]]$headlin, as.data.frame)
    #resultsTaleban[[i+1]]<-ldply(tempJson$results[[i+1]], as.data.frame)
    
    
  }


  resultsOlymipcs
 
 
 resultsDFTaleban <-ldply(resultsTaleban)
 resultsDFOlympics <- ldply(resultsOlymipcs)
 
# resultsDFMovie$Section <-"Movie"
 #resultsDFMovie
resultBig = rbind(resultsDFTaleban,resultsDFOlympics)
dim(resultBig)

resultBig$.id

resultsDFTaleban$`X[[i]]`
resultBig$`X[[i]]`

doc_matrix <- create_matrix(resultBig$`X[[i]]`, language = "english", 
                            removeNumbers = TRUE, stemWords = TRUE)

doc_matrix

theOrder <-sample(60)
container <- create_container(matrix = doc_matrix, labels=resultBig$`X[[i]]`, trainSize = theOrder[1:40], testSize = theOrder[41:60], virgin=FALSE)
theOrder
