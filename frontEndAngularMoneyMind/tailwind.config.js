/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./src/**/*.{html,ts}', './src/index.html'],
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: '#10182B', // azul escuro do logo
          light: '#1A223A',  // azul escuro mais claro
          accent: '#1DE782', // verde do logo
        },
        accent: {
          DEFAULT: '#1DE782', // verde do logo
        },
        neutral: {
          light: '#f5f5f5',  // quase branco
          DEFAULT: '#737373', // cinza médio
          dark: '#171717',   // quase preto
        },
        white: '#fff',
        black: '#000',
      },
      fontFamily: {
        sans: ['Inter', 'sans-serif'],
      },
      keyframes: {
        gradient: {
          "0%, 100%": { backgroundPosition: "0% 50%" },
          "50%": { backgroundPosition: "100% 50%" },
        },
      },
      animation: {
        gradient: "gradient 8s ease infinite",
      },
    },
  },

  plugins: [],
  darkMode: 'class'
};
