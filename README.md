
<a name="readme-top"></a>

<h3 align="center">Besedo Candidate Assignment </h3>
<div>
  <p align="center">
         Besedo Microservice Assignment
    <br />
    <a href="https://github.com/veerao05/Besedo/blob/master/Assignment.txt"><strong>Explore the Assignment »</strong></a>
    <br />
    <br />
    <a href="https://github.com/veerao05/Besedo/issues">Report Bug</a>
    <a href="https://github.com/veerao05/Besedo/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
To build 3 rest points to perform following operations:
1. One endpoint to ingest an JSON object with the following format. Fields have length constraint on min/max, email is required and only one
   of title and body is required.
2. One endpoint to return this data, considering that the dataset will contain a large number of entries. Filtering should also be possible, by a
   single field, one of id, email, title or body.
3. One endpoint that returns a CSV file that is a report on the ingested items, composed of two columns, the first one being the id of the item and
   the second one being the amount of vowels contained in the body.


<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

Following are the technologies used to build the framework.

* [![SpringBoot][spring.io]][Springio-url]
* [![H2][H2.console]][H2-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started
Clone the repository

git clone https://github.com/veerao05/besedo.git

**Setting up the workspace**

After cloning the Repository it can be placed anywhere on your local hard drive.

### Prerequisites & Installation for SpringBoot

### Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [H2](http://www.h2database.com/html/tutorial.html)

## Building the application locally

```
cd <path_of_backend_repo>
mvn clean install
Ex: <MainPath>/besedo/
```

## Deploying the application 
1. Locally
```
Run BesedoMainApplication.java file
```
2. Docker
```
To Build the Docker image:  
cd <MainPath>/besedo/ 
docker build  --tag=besedo:latest . 

To Run the springboot application in container: 
docker run --name=besedo -it -e DATABASE_SERVER=jdbc:h2:mem:testdb -dp 8080:8080 -v ${PWD}/logs:/besedo/logs besedo:latest

To see the container logs:
docker logs -f --tail 10 besedo

To enter inside the container: 
docker exec -it besedo  sh

To stop the container:
docker stop besedo

To delete all the stopped container:
docker container rm $(docker ps -a -q)

To delete the image:
docker rmi <image-id>

To obtain image id:
docker images
```

  
## Rest URL's
Here are some url samples for pagination (with/without filter):

/api/data: using default page and size  

/api/data?page=1&size=5: using 1st page and 5 size

/api/data?size=5: using default value for page

/api/data?id=1&page=1&size=3: pagination & filter by id 

/api/data?title=Senior Engineer&csv=false: pagination & filter by ‘title’ status

/api/data?csv=true: to generate csv report

<!-- ROADMAP -->
## Roadmap/Enhancements
`. Sorting`

`. SQL Db`

`. Error Code Handling`

`. Additional Junit`

`. Update and Delete endpoints`


- [x] Add any suggestions

See the [open issues](https://github.com/veerao05/besedo/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>

Improvements given:
1. Exceptions handling using spring
2. Global exception handling
3. CSV reader null pointer on getBody()
4. Load on get mapping can be done  using indexing should be used.
5. Load on  Post mapping can be done through queues/Spring Batch
6. if (data.charAt(i) == 'a' || data.charAt(i) == 'e' || data.charAt(i) == 'i'
                    || data.charAt(i) == 'o' || data.charAt(i) == 'u') {
                count++;
            }. Use lamda  expression
7. Dont try to throw exceptions from Helper class(Bottom class) . How do you handle the exceptions thrown from bottom class in Upper class.
8. Why Query is used why not getbyId or getByEmail was used? It can be used , to provide pagination all in one method use query here. Alternative is HSQL/getbyId or getByEmail
10. findDataList(String id, String email, String title, String body, Pageable pageable, boolean csv)  - could have used all the paramaters in one class object.
11. Since @lombok.Data is used , controller could have used controller injection. so use @RequiredArgsConstructor 
12. Unit test cases for Controller and service/business layer
13. Entity is directly exposed . so use view object instead of exposing Entity.
14. POST request didnt not return any response message.
15. countVowels(data.getBody()) - handle Null pointer exception in case of GetBody null.
16. email is required and only one of title and body is required.  - Didnt understand the question properly here.
17. Exception handling with different codes could have been done better to the clients.
18. Handling duplicate records.


<!-- CONTRIBUTING -->
## Contributing

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/SampleFeature`)
3. Commit your Changes (`git commit -m 'Add some SampleFeature'`)
4. Push to the Branch (`git push origin feature/SampleFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Your Name - VeenaRao and Email:veenaraofr@gmail.com

Project Link: [https://github.com/veerao05/besedo](https://github.com/veerao05/besedo)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments
List of resources used for project reference.

* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[issues-url]: https://github.com/veerao05/Besedo/issues
[spring.io]: https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white
[Springio-url]: https://spring.io/projects/spring-boot
[H2.console]: https://img.shields.io/badge/H2-00008B?style=for-the-badge&logo=H2&logoColor=white
[H2-url]:  http://www.h2database.com/html/tutorial.html
