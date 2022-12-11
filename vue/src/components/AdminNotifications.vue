<template>
  <section>
    <div class="field" id="notif-housing">
      <div>
        <router-link :to="{ name: 'admin' }">Back to Admin Home</router-link>
        <article class="message is-info">
           <div class="message-header">
            <p>Info</p>
           <button class="delete" aria-label="delete"></button>
           </div>
        <div class="message-body">
          Lorem ipsum dolor sit amet, consectetur adipiscing elit. <strong>Pellentesque risus mi</strong>, tempus quis placerat ut, porta nec nulla. Vestibulum rhoncus ac ex sit amet fringilla. Nullam gravida purus diam, et dictum <a>felis venenatis</a> efficitur. Aenean ac <em>eleifend lacus</em>, in mollis lectus. Donec sodales, arcu et sollicitudin porttitor, tortor urna tempor ligula, id porttitor mi magna a neque. Donec dui urna, vehicula et sem eget, facilisis sodales sem.
        </div>
        </article>
      </div>
      
      
    </div>

    
  </section>
</template>

<script>
export default {};
</script>

<style>
article {
  margin: 20px;
  padding-bottom: 20px;
  
}
.message.is-info .message-header {
    background-color: #573b8a;
    color: #fff;
}
.result-card {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
  display: grid;
  grid-template-columns: 1fr 2fr;
  overflow: hidden;
}

.button {
  color: #fff;
  background: #573b8a;
}

.card-content {
  display: flex;
  flex-direction: column;
}

.movie-info {
  padding: 20px;
}
#notif-housing {
  border: 1px transparent;
  border-radius: 5px;
  background-color: hsl(0 0% 100% / 0.8);
  color: #0f0c29;
  margin: 25px 0px;
}

</style>