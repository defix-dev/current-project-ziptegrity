<script setup>
import NavigationButton from "@/components/services/NavigationButton.vue";
defineProps({
  pagePath: String
});
</script>

<template>
  <link rel="stylesheet" href="/css/app/components/navigation.css" />
  <div class="navigation-container">
    <NavigationButton to="/services/chat" :activePagePath="pagePath" pagePath="chat"/>
    <NavigationButton to="/services/currency_converter" :activePagePath="pagePath" pagePath="currency_converter"/>
    <NavigationButton to="/services/calculator" :activePagePath="pagePath" pagePath="calculator"/>
    <NavigationButton to="/services/weather" :activePagePath="pagePath" pagePath="weather"/>
  </div>
</template>

<style scoped>

</style>