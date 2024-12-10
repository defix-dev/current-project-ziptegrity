<script setup>
import {onMounted} from "vue";
import ReusablePopupMenu from "@/components/services/reusables/ReusablePopupMenu.vue";

defineProps({
  loginAction: Function
});

const registerIconPath = "/images/register_icon.png";
const emit = defineEmits();
const hide = () => emit("hide");
</script>

<template>
  <ReusablePopupMenu :iconPath="registerIconPath" title="Регистрация" @hide="hide">
      <form action="/authorization/register" method="post" class="header-container__authorization-panel login">
        <div class="header-container__authorization-input-layout">
          <label class="header-container__authorization-input-text" for="username">Логин</label>
          <input type="text" class="header-container__authorization-input" id="username" name="username"
                 placeholder="Введите логин..."/>
        </div>
        <div class="header-container__authorization-input-layout">
          <label class="header-container__authorization-input-text" for="password">Пароль</label>
          <input type="password" class="header-container__authorization-input" id="password" name="password"
                 placeholder="Введите пароль..."/>
        </div>
        <div class="header-container__authorization-input-layout">
          <label class="header-container__authorization-input-text" for="repeat-password">Повтор пароля</label>
          <input type="password" class="header-container__authorization-input" id="repeat-password"
                 name="repeat-password" placeholder="Введите пароль еще раз..."/>
        </div>
        <input type="submit" class="header-container__authorization-submit-button" value="Зарегистрироваться"/>
        <span class="header-container__authorization-info-text">Есть аккаунт? <a href="#"
                                                                                 class="header-container__authorization-info-button"
                                                                                 @click="loginAction">Войдите</a></span>
      </form>
  </ReusablePopupMenu>
</template>

<style scoped>

</style>