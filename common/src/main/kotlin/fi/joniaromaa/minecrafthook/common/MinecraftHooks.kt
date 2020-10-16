package fi.joniaromaa.minecrafthook.common

object MinecraftHooks
{
    private val hooksByProtocol: MutableMap<Int, IMinecraftHook> = HashMap()
    private val hooksByName: MutableMap<String, IMinecraftHook> = HashMap()

    @JvmStatic
    fun register(hook: IMinecraftHook)
    {
        val version = hook.version

        this.hooksByProtocol[version.protocolVersion] = hook
        this.hooksByName[version.name] = hook
    }

    @JvmStatic
    fun getHook(protocolVersion: Int): IMinecraftHook? = this.hooksByProtocol[protocolVersion]

    @JvmStatic
    fun getHook(version: String): IMinecraftHook? = this.hooksByName[version]

    @JvmStatic
    val hooks: Collection<IMinecraftHook>
        get() = this.hooksByProtocol.values
}