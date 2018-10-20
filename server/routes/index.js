const userModule = require('../node_modules/users')


module.exports = app => {
    app.get('/', function (req, res) {
        return res.send({status: 'up'})
    })

    app.post('api/login', async function (req, res) {
    	try {
    		const {username, password} = req.body
    		const user = await userModule.login({username, password})
    		res.send({
    			username: user.username
    		})
    	} catch (error) {
    		console.error('error on login', error)
    		res.sendStatus(403)
    	}
    })

    app.post('/api/signup', async function (req, res) {
        const {username, password, confirmPassword} = req.body
        if (!signupCode || !user || !password || !confirmPassword) return res.sendStatus(403)
        if (password !== confirmPassword) return res.sendStatus(403)
         const user = await userModule.createUser({username, password})
     })
}