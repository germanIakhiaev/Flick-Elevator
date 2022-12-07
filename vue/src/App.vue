<template>
  <div id="app">
    <router-view />
  </div>
</template>

<style>
@import "https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css";

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #D6F8D6;
  margin: 60px;
  width: 100%;
}

html {
  height: 100%;
  background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
}

body {
  text-align: center;
  display: flex;
  justify-content: center;
}

button{
	width: 50%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: #fff;
	background: #573b8a;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	outline: none;
	border: none;
	border-radius: 5px;
	transition: .2s ease-in;
	cursor: pointer;
}
button:hover{
	background: #6d44b8;
}
form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

input {
	width: 50%;
}
button{
	width: 60%;
	height: 40px;
	margin: 10px auto;
	justify-content: center;
	display: block;
	color: #fff;
	background: #573b8a;
	font-size: 1em;
	font-weight: bold;
	margin-top: 20px;
	outline: none;
	border: none;
	border-radius: 5px;
	transition: .2s ease-in;
	cursor: pointer;
}


</style>