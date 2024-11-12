<script setup>
import RegisterAuthButtonContent from "@/components/RegisterAuthButtonContent.vue";
import {onMounted} from "vue";
import ReusablePopupMenu from "@/components/reusables/ReusablePopupMenu.vue";

const props = defineProps({
  registerAction: Function
});

const emit = defineEmits();

const loginIconPath = "/images/login_icon.png";
const hide = () => emit("hide");
</script>

<template>
  <ReusablePopupMenu :iconPath="loginIconPath" title="Вход" @hide="hide">
    <form action="/authorization" method="post" class="header-container__authorization-panel login">
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
      <input type="submit" class="header-container__authorization-submit-button" value="Войти"/>
      <span class="header-container__authorization-info-text">Нет аккаунта? <a href="#"
                                                                               class="header-container__authorization-info-button"
                                                                               @click="registerAction">Зарегистрируйтесь</a></span>
    </form>
  </ReusablePopupMenu>
</template>

<style scoped>

</style>