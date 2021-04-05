<h1 align="center">
 <img src="https://www.dropbox.com/s/smrhpyo34uzby64/default-monochrome-black.svg?dl=0?raw=true" alt="Pluto">
</h1>

<p align="center">Pluto is an expense tracking REST API with a JWT based authentication system that performs use-case targetted functionalities to manipulate data stored in an AWS RDS MySQL database</p>


<br>
<div>
  
<p align="center">
  <a href="#api-architecture">Architecture</a> •
  <a href="#token-based-authentication-flow">Token Based Authentication</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#Demo">Demo</a> •
  <a href="#endpoints">Endpoints</a> •
  <a href="#credits">Credits</a> •
  <a href="#license">License</a>
</p>

</div>

<br>

## API Architecture
![alt text](https://www.dropbox.com/s/smrhpyo34uzby64/default-monochrome-black.svg?raw=true)


## Token Based Authentication Flow

![alt text](https://www.dropbox.com/s/k711608rf804vms/Token%20Auth.jpg?raw=true)

<br>

## Endpoints

<table>
<thead>
<tr>
<th>Verb</th>
<th>URI</th>
<th>Action</th>
<th>Route Name</th>
</tr>
</thead>
<tbody>
<tr>
<td>GET</td>
<td><code>/rooms</code></td>
<td>index</td>
<td>rooms.index</td>
</tr>
<tr>
<td>POST</td>
<td><code>/users/create</code></td>
<td>create</td>
<td>hotels.create</td>
</tr>
 <tr>
<td>POST</td>
<td><code>/sessions</code></td>
<td>login</td>
<td>sessions.create</td>
</tr>
<tr>
<td>POST</td>
<td><code>/rooms</code></td>
<td>store</td>
<td>rooms.create</td>
</tr>
<tr>
<td>GET</td>
<td><code>/rooms/{id}</code></td>
<td>show</td>
<td>rooms.show</td>
</tr>
<tr>
<td>PUT/PATCH</td>
<td><code>/rooms/{id}</code></td>
<td>update</td>
<td>rooms.update</td>
</tr>
<tr>
<td>PUT/PATCH</td>
<td><code>/sessions/{id}</code></td>
<td>token refresh</td>
<td>sessions.update</td>
</tr>
<tr>
<tr>
<td>GET</td>
<td><code>/rooms/available</code></td>
<td>show</td>
<td>rooms.showAvailable</td>
</tr>
<tr>
 <tr>
<td>GET</td>
<td><code>/rooms/unavailable</code></td>
<td>show</td>
<td>rooms.showAvailable</td>
</tr>
<tr>
<td>DELETE</td>
<td><code>/rooms/{id}</code></td>
<td>destroy</td>
<td>rooms.delete</td>
</tr>
 <tr>
<td>DELETE</td>
<td><code>/sessions/{id}</code></td>
<td>logout</td>
<td>sessions.delete</td>
</tr>
</tbody>
</table>

<br>

## Key Features
* Robust API developed using only pure PHP.
* Performs CRUD operations on a MySQL database.
* Caching system for faster data retrieval.
* Token based authentication system.
* Password encryption for security.
* Industry standard endpoints.

<br>

## Demo

#### Create new user

![alt text](https://www.dropbox.com/s/9k17qz48rgi73zu/create_user.gif?raw=true)

<br>

#### Login

![alt text](https://www.dropbox.com/s/rnepbcoma6orjq6/login.gif?raw=true)

<br>

#### Add available room into inventory

![alt text](https://www.dropbox.com/s/11gy9ltbtdpfp53/create_room.gif?raw=true)

<br>

#### Fetch all rooms matching the hotel ID

![alt text](https://www.dropbox.com/s/qo2ipuxazzx7f6h/get_rooms.gif?raw=true)

<br>

#### Logout

![alt text](https://www.dropbox.com/s/l50r4xz6j8lfdzm/logout.gif?raw=true)

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
