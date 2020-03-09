package di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DependencyInjector {
	private List<Injector> injectors;

	private Map<Class<? extends Injectable>, List<Injectable>> registeredInstances;

	private Map<Class<? extends Injectable>, Service> mapInjectableService;

	private Map<Injector, Class<? extends Injectable>> mapInjectorInjectable;

	public DependencyInjector() {
		injectors = new ArrayList<>();
		registeredInstances = new HashMap<>();
		mapInjectableService = new HashMap<>();
		mapInjectorInjectable = new HashMap<>();
	}

	public void addInjector(final Injector injector, final Class<? extends Injectable> injectable) {
		injectors.add(injector);
		registeredInstances.put(injectable, new ArrayList<Injectable>());
		mapInjectorInjectable.put(injector, injectable);
	}

	public void register(final Injectable instance) {
		for (Entry<Class<? extends Injectable>, List<Injectable>> entry : registeredInstances.entrySet()) {
			Class<? extends Injectable> interfaceEnregistree = entry.getKey();
			for (Class<?> interfaceDeLInstance : instance.getClass().getInterfaces()) {
				if (interfaceDeLInstance.equals(interfaceEnregistree)) {
					List<Injectable> list = entry.getValue();
					list.add(instance);
					entry.setValue(list);
				}
			}
		}
	}

	public void addRuntimeInstance(final Class<? extends Injectable> injectable, final Service service) {
		mapInjectableService.put(injectable, service);
	}

	public void inject() {
		for (Injector injector : injectors) {
			Class<? extends Injectable> injectable = mapInjectorInjectable.get(injector);
			Service service = mapInjectableService.get(injectable);
			injector.inject(service);
		}
	}

	public List<Injectable> getInstancesByClass(final Class<? extends Injectable> injectable) {
		return registeredInstances.get(injectable);
	}

}
