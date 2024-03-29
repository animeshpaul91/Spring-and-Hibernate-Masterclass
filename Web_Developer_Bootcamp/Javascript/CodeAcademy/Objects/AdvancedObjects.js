let robot = {
    model: 'B-4MI',
    mobile: true,
    greetMaster() {
        console.log(`I'm model ${this.model}, how may I be of service?`);
    }
}

const massProdRobot = (model, mobile) => {
    return {
        model,
        mobile,
        greetMaster() {
            console.log(`I'm model ${this.model}, how may I be of service?`);
        }
    }
}

const shinyNewRobot = massProdRobot('TrayHax', true)

const chargingStation = {
    _name: 'Electrons-R-Us',
    _robotCapacity: 120,
    _active: true,
    _chargingRooms: ['Low N Slow', 'Middle of the Road', 'In and Output'],

    set robotCapacity(newCapacity) {
        if (typeof newCapacity === 'number') {
            this._robotCapacity = newCapacity;
        } else {
            console.log(`Change ${newCapacity} to a number.`)
        }
    },
    get robotCapacity() {
        return this._robotCapacity;
    }
}

// The this keyword

robot = {
    model: '1E78V2',
    energyLevel: 100,
    provideInfo() {
        return (`I am ${this.model} and my current energy level is ${this.energyLevel}.`);
    }
};

console.log(robot.provideInfo());

robot = {
    energyLevel: 100,
    checkEnergy(){
        console.log(`Energy is currently at ${this.energyLevel}%.`)
    }
}

robot.checkEnergy();

robot = {
    _energyLevel: 100,
    recharge(){
        this._energyLevel += 30;
        console.log(`Recharged! Energy is currently at ${this._energyLevel}%.`)
    }
};

robot._energyLevel = 'high';
robot.recharge();

robot = {
    _model: '1E78V2',
    _energyLevel: 100,
    get energyLevel(){
        if(typeof this._energyLevel === 'number') {
            return 'My current energy level is ' + this._energyLevel
        } else {
            return "System malfunction: cannot retrieve energy level"
        }
    }
};

console.log(robot.energyLevel);

// Setters
robot = {
    _model: '1E78V2',
    _energyLevel: 100,
    _numOfSensors: 15,
    get numOfSensors(){
        if(typeof this._numOfSensors === 'number'){
            return this._numOfSensors;
        } else {
            return 'Sensors are currently down.'
        }
    },

    set numOfSensors(num) {
        if (typeof num === 'number' && num >= 0) {
            this._numOfSensors = num;
        }
        else {
            console.log('Pass in a number that is greater than or equal to 0');
        }
    }
};

robot.numOfSensors = 100;
console.log(robot.numOfSensors);

// Factory Functions
const robotFactory = (model, mobile) => {
    return {
        'model': model,
        'mobile': mobile,
        beep() {
            console.log('Beep Boop');
        }
    }
}

const tinCan = robotFactory('P-500', true);
tinCan.beep();

function robotFactory1(model, mobile){
    return {
        model,
        mobile,
        beep() {
            console.log('Beep Boop');
        }
    }
}

// To check that the property value shorthand technique worked:
let newRobot = robotFactory1('P-501', false)
console.log(newRobot.model)
console.log(newRobot.mobile)

robot = {
    model: '1E78V2',
    energyLevel: 100,
    functionality: {
        beep() {
            console.log('Beep Boop');
        },
        fireLaser() {
            console.log('Pew Pew');
        },
    }
};

const {functionality} = robot; // Extract functinality Object from robot
functionality.beep();

// Built in Object Methods
robot = {
    model: 'SAL-1000',
    mobile: true,
    sentient: false,
    armor: 'Steel-plated',
    energyLevel: 75
};

// What is missing in the following method call?
const robotKeys = Object.keys(robot);

console.log(robotKeys);

// Declare robotEntries below this line:
const robotEntries = Object.entries(robot);

console.log(robotEntries);

// Declare newRobot below this line:
newRobot = {laserBlaster: true, voiceRecognition: true};
Object.assign(newRobot, robot);
console.log(newRobot);