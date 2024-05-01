# Problem Statement
You will build a web application with any language or framework you like, deployed on an EC2 instance behind a Virtual Private Cloud (VPC).  
Your application running on EC2 will be public facing and listening to POST requests to **/store-products** and GET requests to **/list-products**.

## /store-products:
•	Receive and parse a JSON body.
•	Connect to an AWS RDS database server running on a private subnet inside your VPC.
•	Insert one record into the products table in the database for each item in the products array in the JSON body.
•	Return a status 200 code if everything works, or the appropriate HTML status code if there is an error or invalid input.

Input JSON:  
{  
   &emsp;"products": \[{  
         &emsp;&emsp;"name": "\<a name>",  
         &emsp;&emsp;"price": "\<a price>",  
         &emsp;&emsp;"availability": \<true or false>  
      &emsp;},  
      &emsp;{  
         &emsp;&emsp;"name": "\<yet another name>",  
         &emsp;&emsp;"price": "\<yet another price>",  
         &emsp;&emsp;"availability": \<true or false>  
      &emsp;},  
      ...  
   &emsp;]  
}

## /list-products:
•	Connect to the AWS RDS database running on the private subnet inside your VPC.
•	Query the products table and return a list of all products with status 200 code.

## RDS Database (Aurora MySQL):
Your database must contain a single table named products that has the following schema:

CREATE TABLE csci_5409_a2_database.products (  
	&emsp;name varchar(100),  
	&emsp;price varchar(100),  
	&emsp;availability boolean  
);

### Note:
•	The EC2 should only be open to HTTP, HTTPS and SSH
•	The RDS should be in a private subnet
•	The RDS instance should only be open to the EC2 instance
•	The EC2 and RDS should be in the same VPC
•	The app’s response to /store-products should be successful
•	The app’s response to /list-products should give the products information






