package net.rjbash.chaosvkostce.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rjbash.chaosvkostce.ChaosvKostce;



public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChaosvKostce.MOD_ID);

    public static  final RegistryObject<SoundEvent> RICHARD_BLOCK_BREAK = registerSoundEvent("richard_block_break");
    public static  final RegistryObject<SoundEvent> RICHARD_BLOCK_STEP = registerSoundEvent("richard_block_step");
    public static  final RegistryObject<SoundEvent> RICHARD_BLOCK_PLACE = registerSoundEvent("richard_block_place");
    public static  final RegistryObject<SoundEvent> RICHARD_BLOCK_HIT = registerSoundEvent("richard_block_hit");
    public static  final RegistryObject<SoundEvent> RICHARD_BLOCK_FALL = registerSoundEvent("richard_block_fall");




    public static final ForgeSoundType RICHARD_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.RICHARD_BLOCK_BREAK, ModSounds.RICHARD_BLOCK_STEP,ModSounds.RICHARD_BLOCK_PLACE,ModSounds.RICHARD_BLOCK_HIT,
            ModSounds.RICHARD_BLOCK_FALL);
    public static final  RegistryObject<SoundEvent> SWEET_DELICIOUS = registerSoundEvent("sweet_delicious");
    public static final ResourceKey<JukeboxSong> SWEET_DELICIOUS_KEX = ResourceKey.create(Registries.JUKEBOX_SONG,ResourceLocation.fromNamespaceAndPath(ChaosvKostce.MOD_ID, "sweet_delicious"));


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ChaosvKostce.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
