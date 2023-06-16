Java Application to interact with the reddit API and do operations on the data fetched.
Made using Spring framework build using Gradle and MongoDB database.
Used Jackson library to map the JSON data to Java objects for storing in the database.

API’s used-
1. https://www.reddit.com/api/v1/access_token
      To get the auth token for using the Reddit API.
2. https://oauth.reddit.com
      Base URL for calling the Reddit API.


Endpoints used-
1. /r/subreddit/new
       For fetching the posts from a subreddit.
2. /api/submit
       For posting a post on reddit.


Endpoints created-
1. /user/test/{subreddit_name}
      For fetching the posts of a particular subreddit and storing it in the database.
2. /user/get/{user_name}
      For getting the posts of a particular user from the database.
3. /user/delete/{user_name}
      For deleting the posts of a particular user from the database.
4. /user/keyword/{word}
      For getting the posts whose body contains a particular keyword from the database.
5. /user/sort
      To get the posts from the database sorted by date of post.
6. /reddit/post
      To post on a subreddit on reddit and also storing the latest posts of that subreddit on the database.
