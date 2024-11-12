<script setup>
import LoginAuthButtonContent from "@/components/LoginAuthButtonContent.vue";
import RegisterAuthButtonContent from "@/components/RegisterAuthButtonContent.vue";
import {computed} from "vue";
import {authPanType} from "@/router/index.js";

const props = defineProps({
  login: Boolean,
  panState: Number
});

const emit = defineEmits(['update:panState']);
const setPanState = (state) => emit('update:panState', state);
const hide = () => setPanState(authPanType.HIDE);
</script>

<template>
  <div v-if="login">
    <LoginAuthButtonContent @hide="hide" :registerAction="() => setPanState(authPanType.REGISTER)"/>
  </div>
  <div v-else>
    <RegisterAuthButtonContent @hide="hide" :loginAction="() => setPanState(authPanType.LOGIN)"/>
  </div>
</template>

<style scoped>

</style>