import telegram.ext
from telegram import InlineKeyboardButton, InlineKeyboardMarkup

TOKEN = "5544054333:AAGt__sHvHACotN3azOVM_GP4q5I4j9qx7M"
ONE, TWO, THREE, FOUR, FIVE, SIX = range(6)


def start(update, context):
    user = update.message.chat.username
    name = update.message.chat.first_name
    text = f"Hello!! Welcome to jenkins bot {name}"
    keyboard = [
        [
            InlineKeyboardButton("Show me the Jobs", callback_data=str(ONE)),
        ]
    ]
    reply_markup = InlineKeyboardMarkup(keyboard)
    update.message.reply_text(text, reply_markup=reply_markup)


def helper(update, context):
    update.message.reply_text("""
        Greetings!!
        Welcome to Jenkins bot! 
        For any queries please send message to mkanwaljeet18995@gmail.com
        Please use the below commands to trigger jenkins build
        /start - Start the bot
        /help - Call for help
        /Regression - Run the regression test job
        /Smoke - Run the smoke test job
        /QA - run the build in QA
        /TEST - run the build in test environment
        /DEV - run the build in dev environment
    """)


updater = telegram.ext.Updater(TOKEN, use_context=True)
disp = updater.dispatcher

disp.add_handler(telegram.ext.CommandHandler("start", start))
disp.add_handler(telegram.ext.CommandHandler("helper", help))

updater.start_polling()
updater.idle()
