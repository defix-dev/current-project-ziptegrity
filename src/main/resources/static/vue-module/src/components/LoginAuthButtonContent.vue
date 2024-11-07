<script setup>
import RegisterAuthButtonContent from "@/components/RegisterAuthButtonContent.vue";
import {onMounted} from "vue";

const props = defineProps({
  closeAction: Function,
  registerAction: Function
});

const loginIconPath = "/images/login_icon.png";
const closeIconPath = "/images/close_icon.png";

const emit = defineEmits();
onMounted(() => emit("open"));

const close = () => {
  emit("close");
  props.closeAction();
}
</script>

<template>
  <div class="header-container__authorization">
    <form action="/authorization" method="post" class="header-container__authorization-panel login">
      <div class="header-container__authorization-up">
        <span class="header-container__authorization-title">
      <img :src="loginIconPath" alt="login_icon" class="header-container__authorization-method-icon"/>Вход</span>
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
      <input type="submit" class="header-container__authorization-submit-button" value="Войти"/>
    </form>
    <span class="header-container__authorization-info-text">Нет аккаунта? <a href="#" class="header-container__authorization-info-button" @click="registerAction">Зарегистрируйтесь</a></span>
  </div>
</template>

<style scoped>

</style>