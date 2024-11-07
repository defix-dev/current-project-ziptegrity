import { createRouter, createWebHistory } from 'vue-router';
import CurrencyConverterService from "@/components/currencyConverter/CurrencyConverterService.vue";
import ChatService from "@/components/chat/ChatService.vue";
import CalculatorService from "@/components/calculator/CalculatorService.vue";
import WeatherService from "@/components/weather/WeatherService.vue";

const routes = [
    { path: '/services/chat', name: 'Chat', component: ChatService },
    { path: '/services/currency_converter', name: 'CurrencyConverter', component: CurrencyConverterService },
    { path: '/services/calculator', name: 'Calculator', component: CalculatorService },
    { path: '/services/weather', name: 'Weather', component: WeatherService }
];

export const pageType = {
    chat: "Чат",
    calculator: "Калькулятор",
    currency_converter: "Конвертатор валют",
    weather: "Погода"
}

export const authPanType = Object.freeze({
    LOGIN: 0,
    REGISTER: 1,
    HIDE: 2
});

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
