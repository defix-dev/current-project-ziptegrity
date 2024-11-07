<script setup>
import {onMounted} from "vue";

const props = defineProps({
  closeAction: Function,
  loginAction: Function
});

const closeIconPath = "/images/close_icon.png";
const registerIconPath = "/images/register_icon.png";

const emit = defineEmits();
onMounted(() => emit("open"));

const close = () => {
  emit("close");
  props.closeAction();
}
</script>

<template>
  <div class="header-container__authorization">
    <form action="/authorization/register" method="post" class="header-container__authorization-panel login">
      <div class="header-container__authorization-up">
        <span class="header-container__authorization-title">
      <img :src="registerIconPath" alt="login_icon" class="header-container__authorization-method-icon"/>Регистрация</span>
        <a href="#" class="header-container__authorization-close-button" @click="close"><img :src="closeIconPath" alt="close_icon"/></a>
      </div>
      <div class="header-container__authorization-input-layout">
        <label class="header-container__authorization-input-text" for="username">Логин</label>
        <input type="text" class="header-container__authorization-input" id="username" name="username" placeholder="Введите логин..."/>
      </div>
      <div class="header-container__authorization-input-layout">
        <label class="header-container__authorization-input-text" for="password">Пароль</label>
        <input type="password" class="header-container__authorization-input" id="password" name="password" placeholder="Введите пароль..."/>
      </div>
      <div class="header-container__authorization-input-layout">
        <label class="header-container__authorization-input-text" for="repeat-password">Повтор пароля</label>
        <input type="password" class="header-container__authorization-input" id="repeat-password" name="repeat-password" placeholder="Введите пароль еще раз..."/>
      </div>
      <input type="submit" class="header-container__authorization-submit-button" value="Зарегистрироваться"/>
    </form>
    <span class="header-container__authorization-info-text">Есть аккаунт? <a href="#" class="header-container__authorization-info-button" @click="loginAction">Войдите</a></span>
  </div>
</template>

<style scoped>

</style>