<h1 align="center">
 <img src="https://www.dropbox.com/s/az1urfq4bs9pkvz/default-monochrome-black.png?raw=true" alt="Spense">
</h1>

![alt text](https://www.dropbox.com/s/smrhpyo34uzby64/default-monochrome-black.svg?raw=true)

<p align="center">Spense is an expense tracking REST API with a JWT based authentication system that performs use-case targetted functionalities to manipulate data stored in an AWS RDS MySQL database</p>


<br>
<div>
  
<p align="center">
  <a href="#er-diagram">ER Diagram</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#Demo">Demo</a> •
  <a href="#endpoints">Endpoints</a> •
  <a href="#credits">Credits</a> •
  <a href="#license">License</a>
</p>

</div>

<br>

## ER Diagram
![alt text](https://www.dropbox.com/s/77ptw5hm87sv9ci/SpenseDB.png?raw=true)

<br>

## Endpoints

<table>
<thead>
<tr>
<th>Verb</th>
<th>URI</th>
<th>Action</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td>POST</td>
<td><code>/users/register</code></td>
<td>create</td>
<td>creates new user</td>
</tr>
 <tr>
<td>POST</td>
<td><code>/login</code></td>
<td>create</td>
<td>returns JWT token</td>
</tr>
<tr>
<tr>
<td>GET</td>
<td><code>/categories</code></td>
<td>index</td>
<td>returns all categories for a user</td>
</tr>
<td>POST</td>
<td><code>/categories/create</code></td>
<td>create</td>
<td>creates new category</td>
</tr>
<tr>
<td>GET</td>
<td><code>/categories/{id}</code></td>
<td>show</td>
<td>returns category with matching ID</td>
</tr>
<tr>
<td>PUT/PATCH</td>
<td><code>/categories/{id}</code></td>
<td>update</td>
<td>updates category with matching ID</td>
</tr>
<tr>
<td>DELETE</td>
<td><code>/categories/{id}</code></td>
<td>destroy</td>
<td>deletes category with matching ID</td>
</tr>
<tr>
<td>GET</td>
<td><code>/transactions</code></td>
<td>index</td>
<td>returns all user transactions</td>
</tr>
<tr>
<td>GET</td>
<td><code>/transactions/{id}</code></td>
<td>show</td>
<td>returns all user transactions with matching ID</td>
</tr>
<tr>
<td>GET</td>
<td><code>/transactions/category/{id}</code></td>
<td>show</td>
<td>returns all user transactions of a particular category</td>
</tr>
<tr>
<td>PUT/PATCH</td>
<td><code>/transactions/{id}</code></td>
<td>update</td>
<td>updates transaction with matching ID</td>
</tr>
<tr>
<td>DELETE</td>
<td><code>/transactions/{id}</code></td>
<td>destroy</td>
<td>deletes all transactions with matching ID</td>
</tr>
</tbody>
</table>

<br>

## Key Features
* REST API developed using Spring Boot 2.
* Performs CRUD operations on a MySQL database with caching mechanism.
* Many-to-One relationships between entities.
* JWT based authentication system.
* SHA-256 password encryption for security.

<br>

## Demo

#### Retreive transactions belonging to a specific category

![alt text](https://www.dropbox.com/s/lyadzz68sx56j03/getTransactionsByCategory.gif?raw=true)

<br>

## Credits

* API testing done via [Postman](https://www.postman.com)
* Databased used: [MySQL](https://www.mysql.com/) hosted via [Clever Cloud](https://www.clever-cloud.com/en/)

<br>

## License

MIT

---

> Portfolio [supreeth.live](https://devfolio.co/@supreeth7700) &nbsp;&middot;&nbsp;
> GitHub [@supreeth7](https://github.com/supreeth7) &nbsp;&middot;&nbsp;
> Instagram [@iam.supreeth](https://www.instagram.com/iam.supreeth)
