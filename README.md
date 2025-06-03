# Java Slot Machine 🎰

A simple console-based slot machine game written in Java. Users can deposit money, place bets, and spin for a chance to win based on randomly generated emoji symbols.

## 🎮 Features

- Console-based user interface
- Emoji symbols for slot visuals
- Betting system with balance tracking
- Random spin generation
- Payout logic for symbol matches

## 🔧 How It Works

1. User is prompted to deposit an initial balance.
2. User places a bet (must be less than or equal to current balance).
3. The slot machine spins 3 symbols randomly.
4. Payout is calculated based on matching symbols:
    - 3 matching symbols: higher reward
    - 2 matching symbols: smaller reward
    - No match: loss of bet
5. Game continues until the user quits or runs out of money.

## 🖥️ Technologies Used

- Java (Standard Edition)
- `java.util.Scanner`
- `java.util.Random`
