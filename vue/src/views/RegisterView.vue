<template>
  <div class="view">
  <div id="register" class="text-center">
    <form v-on:submit.prevent="register" class="register-group">
      <h1 class ="title">Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        
        <input type="text" placeholder="Username" id="username" class="input" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        
        <input type="password"  placeholder="Password" id="password" class="input" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        
        <input type="password" placeholder="Confirm Password" id="confirmPassword" class="input" v-model="user.confirmPassword" required />
      </div>
      <div class="btn-container"><button type="button" class="btn create-account" @click="register()">Create Account</button> </div>
      <p><router-link v-bind:to="{ name: 'login' }" class="login-here">Already have an account? Log in.</router-link></p>
    </form>
  </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
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
#register {
  display: flex;
  justify-content: center; 
  align-items:center; 
  height: 85vh; 
  position: absolute;
  width: 100vw;
  background: #334e49ce;
  display: flex;
  flex-direction: column;
  
  
}
.register-group {
  border: 2px solid #8BBAB1; 
  background-color:  #FFFDF1;
  border-radius: 10px; 
  padding-left: 6rem;
  padding-right: 6rem; 

}

.title {
  margin-top: 2rem;
  color: #193144;
  margin-bottom: 10px;
  
}
.input {
  padding: 5px;
  margin: 5px;
  font-style: italic;
}

#username,
#password,
#confirmPassword{
  width: 250px; 
  border-radius: 15px;
  
}
.btn-container {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
  text-decoration: none;
}
.create-account {
    display: flex;
    color: #193144;
    background-color: #FFC6C7;
    justify-self: center;
    text-decoration: none;
    align-items: center;
    justify-content: center;
    margin-bottom: 20px;
 
}

.create-account:hover {
    background-color: #ff9e9f;
    color: #193144;
}
label {
  margin-right: 0.5rem;
}
.login-here {
  text-decoration: none;
  color:#193144b4;
}
.login-here:hover {
  color:#193144d5;
}


</style>
