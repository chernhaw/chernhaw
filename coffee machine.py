# This is a sample Python script.

# Press ⌃R to execute it or replace it with your code.
# Press Double ⇧ to search everywhere for classes, files, tool windows, actions, and settings.
MENU = {
    "espresso": {
        "ingredients": {
            "water": 50,
            "coffee": 18,
        },
        "cost": 1.5,
    },
    "latte": {
        "ingredients": {
            "water": 200,
            "milk": 150,
            "coffee": 24,
        },
        "cost": 2.5,
    },
    "cappuccino": {
        "ingredients": {
            "water": 250,
            "milk": 100,
            "coffee": 24,
        },
        "cost": 3.0,
    }
}

resources = {
    "water": 300,
    "milk": 400,
    "coffee": 400,
}

coins = {
    "quarters": 0.25,
    "dimes": 0.1,
    "nickles": 0.05,
    "pennies": 0.01
}

money = 0

def checkResource(drink):
    print(f'Drink selected {drink}')

    
    if (drink == 'espresso'):
        drink='espresso'
        # Check resource needed
        waterNeededDrink = MENU['espresso']['ingredients']['water']
        print (f'Water needed {waterNeededDrink}')
        coffeeNeededForDrink = MENU['espresso']['ingredients']['coffee']
        print(f'Coffee needed {coffeeNeededForDrink}')

        # Check resource left
        waterLeftDrink = resources['water']
        coffeeLeftDrink = resources['coffee']
        # print(f'Water left {waterLeftDrink}')
        # print(f'Coffee left {coffeeLeftDrink}')

        if (waterLeftDrink<waterNeededDrink):
            return "Sorry there are not enough water"
        elif (coffeeLeftDrink<coffeeNeededForDrink):
            return "Sorry there are not enough coffee"
        payDrink(drink)
        dispenseDrink(drink)

    elif (drink == 'latte'):

        # Check resource needed
        waterNeededDrink = MENU['latte']['ingredients']['water']
        print (f'Water needed {waterNeededDrink}')
        coffeeNeededForDrink = MENU['latte']['ingredients']['coffee']
        print(f'Coffee needed {coffeeNeededForDrink}')
        milkNeededForDrink = MENU['latte']['ingredients']['coffee']
        print(f'Milk needed {milkNeededForDrink}')

        # Check resource left
        waterLeftDrink = resources['water']
        coffeeLeftDrink = resources['coffee']
        milkLeftDrink = resources['milk']
        # print(f'Water left {waterLeftDrink}')
        # print(f'Coffee left {coffeeLeftDrink}')
        # print(f'Milk left {milkLeftDrink}')

        if (waterLeftDrink<waterNeededDrink):
            return "Sorry there are not enough water"
        elif (coffeeLeftDrink<coffeeNeededForDrink):
            return "Sorry there are not enough coffee"
        elif (milkLeftDrink<milkNeededForDrink):
            return "Sorry there are not enough milk"

        payDrink(drink)
        dispenseDrink(drink)


    elif (drink == 'cappuccino'):

        # Check resource needed
        waterNeededDrink = MENU['cappuccino']['ingredients']['water']
        print (f'Water needed {waterNeededDrink}')
        coffeeNeededForDrink = MENU['cappuccino']['ingredients']['coffee']
        print(f'Coffee needed {coffeeNeededForDrink}')
        milkNeededForDrink = MENU['cappuccino']['ingredients']['coffee']
        print(f'Milk needed {milkNeededForDrink}')

        # Check resource left
        waterLeftDrink = resources['water']
        coffeeLeftDrink = resources['coffee']
        milkLeftDrink = resources['milk']
        # print(f'Water left {waterLeftDrink}')
        # print(f'Coffee left {coffeeLeftDrink}')
        # print(f'Milk left {milkLeftDrink}')

        if (waterLeftDrink<waterNeededDrink):
            return "Sorry there are not enough water"
        elif (coffeeLeftDrink<coffeeNeededForDrink):
            return "Sorry there are not enough coffee"
        elif (milkLeftDrink<milkNeededForDrink):
            return "Sorry there are not enough milk"




def dispenseDrink(drink):
    #Get current resource
    waterLeftDrink = resources['water']
    coffeeLeftDrink = resources['coffee']
    milkLeftDrink = resources['milk']

    waterLeftDrink = waterLeftDrink - MENU[drink]['ingredients']['water']
    coffeeLeftDrink = coffeeLeftDrink - MENU[drink]['ingredients']['water']
    milkLeftDrink = milkLeftDrink - MENU[drink]['ingredients']['water']

    resources['water'] = waterLeftDrink;
    resources['coffee'] = coffeeLeftDrink;
    resources['milk'] = milkLeftDrink

    print (f'{drink} dispensed')
    print(f'Water left {waterLeftDrink}')
    print(f'Coffee left {coffeeLeftDrink}')
    print(f'Milk left {milkLeftDrink}')



# Dispense coin

# prompt user to dispense coins
def payDrink(drink):

    costofDrink = MENU[drink]['cost']

    print(f'Please pay ${costofDrink}, insert coins:')
    quarters_inserted = float(input('Number of quarters inserted : '))
    dimes_inserted = float(input('Number of dimes inserted : '))
    nickles_inserted = float(input('Number of nickles inserted : '))
    pennies_inserted = float(input('Number of pennies inserted : '))


    amount_paid = quarters_inserted * coins['quarters']
    +dimes_inserted*coins['dimes']
    +nickles_inserted*coins['nickles']
    +pennies_inserted*coins['pennies']

    changes = amount_paid-costofDrink
    if changes < 0.0:
        print(f'Sorry, short of {changes}')
        return False
    elif changes == 0.0:
        return True
    else:
        print (f'Here is your change of ${changes}')
        return True


# user dispense coins
# check if amount is enough
#   dispense drink
# return change



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    order = ''
    while (order !="Off" or order !="off"):
        if order == '':
            order = input("What would you like? (espresso/latte/cappuccino): ")

        if (order == 'report'):
            print(f'Water: {resources["water"]}ml')
            print(f'Milk: {resources["milk"]}ml')
            print(f'Coffee: {resources["coffee"]}g')
            print(f'Money: ${money}')

        if (order == 'espresso' or order == 'latte' or order=='cappuccino'):
         #   print(checkResource(order))
            paid = payDrink(order)

            if paid == True:
                dispenseDrink(order)
                order=''



# See PyCharm help at https://www.jetbrains.com/help/pycharm/
