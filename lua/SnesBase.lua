sendTable = {}
sendOut = function ()
  for k,v in pairs(sendTable) do
    tcp:send(k.."="..v..",")
  end
  tcp:send("\n")
end
reConnect = function ()
  
  socket = require("socket")
  tcp = assert(socket.tcp())
  tcp:connect("127.0.0.1", 25565);
  sendOut()
  tcp:close()
end
addOrUpdate = function (name, value)
  sendTable[name] = value
  end
while true do
  --Main Loop
  
  --End Main Loop
  --Transferring data to Java
  reConnect()
  --Data Transfer to Java Complete
  snes9x.frameadvance()
  end