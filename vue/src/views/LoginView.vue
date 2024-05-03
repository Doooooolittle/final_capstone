<template>
  <div class="view">
    <div id="login">
      <form v-on:submit.prevent="login()" class="login-group">
        <h1 class="title">Please Sign In</h1>
        <div role="alert" v-if="invalidCredentials">
          Invalid username and password!
        </div>
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="form-input-group">
          <input type="text" placeholder="Username" id="username" class="input" v-model="user.username" required
            autofocus />
        </div>
        <div class="form-input-group">
          <input type="password" placeholder="Password" id="password" class="input" v-model="user.password" required />
        </div>
        <router-link v-bind:to="{ name: 'dashboard' }" class="btn-container"><button type="submit"
            class="btn btn-sign-in"  @click="login()">Sign in</button></router-link>
        <p><router-link v-bind:to="{ name: 'register' }" class="register-here">New to Castles Of Japan? Register
            Here.</router-link></p>
      </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/dashboard");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.view {
  display: flex;
  justify-content: center;
  height: 85vh;
  width: 100vw;
  position: relative;
  background-size: hidden;
  background-position: 25%;
  background-image: url(https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/db8b062b-2365-4be4-a2f4-2a0ee3553f55/daudt2o-7ab53a46-ded6-4228-b936-08294957512e.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcL2RiOGIwNjJiLTIzNjUtNGJlNC1hMmY0LTJhMGVlMzU1M2Y1NVwvZGF1ZHQyby03YWI1M2E0Ni1kZWQ2LTQyMjgtYjkzNi0wODI5NDk1NzUxMmUucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.ciooYX17aadfy6CJagfXxTr-7WgwgzVSeihUoPMorDw);
}

#login {
  display: flex;
  align-items: center;
  height: 85vh;
  position: absolute;
  width: 100vw;
  background: #334e49ce;
  display: flex;
  justify-content: center;
  flex-direction: column;
}

.login-group {
  border: 2px solid #8BBAB1;
  background-color: #FFFDF1;
  border-radius: 10px;
  padding-left: 5rem;
  padding-right: 5rem;

}

.title {
  margin-top: 2rem;
  color: #193144;
  margin-bottom: 10px;
}

.input {
  padding: 5px;
  margin: 10px;
  font-style: italic;
}

#username,
#password {
  width: 250px;
  border-radius: 15px;
  margin-bottom: 1rem;

}

.btn-container {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
  text-decoration: none;
}

.btn-sign-in {
  display: flex;
  color: #193144;
  background-color: #FFC6C7;
  justify-self: center;
  text-decoration: none;
  align-items: center;
}

.btn-sign-in:hover {
  background-color: #ff9e9f;
  color: #193144;
}

.register-here {
  text-decoration: none;
  color: #193144b4;

}

.register-here:hover {
  color: #193144d5;
  
}</style>