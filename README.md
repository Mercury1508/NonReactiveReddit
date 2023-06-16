Java Application to interact with the reddit API and do operations on the data fetched.
Made using Spring framework build using Gradle and MongoDB database.
Used Jackson library to map the JSON data to Java objects for storing in the database.

API’s used-
1. https://www.reddit.com/api/v1/access_token
     <br> To get the auth token for using the Reddit API.
2. https://oauth.reddit.com
      <br>Base URL for calling the Reddit API.


Endpoints used-
1. /r/subreddit/new
       <br>For fetching the posts from a subreddit.
2. /api/submit
       <br>For posting a post on reddit.


Endpoints created-
1. /user/test/{subreddit_name}
      <br>For fetching the posts of a particular subreddit and storing it in the database.
2. /user/get/{user_name}
      <br>For getting the posts of a particular user from the database.
3. /user/delete/{user_name}
      <br>For deleting the posts of a particular user from the database.
4. /user/keyword/{word}
      <br>For getting the posts whose body contains a particular keyword from the database.
5. /user/sort
      <br>To get the posts from the database sorted by date of post.
6. /reddit/post
      <br>To post on a subreddit on reddit and also storing the latest posts of that subreddit on the database.
